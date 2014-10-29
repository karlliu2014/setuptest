package com.pivotal.q1.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.pivotal.q1.model.Album;
import com.pivotal.q1.model.Product;
import com.pivotal.q1.model.Song;

@Repository
@Transactional (propagation=Propagation.REQUIRED)
public class Q2Dao extends BaseDao	{
	private static final Logger logger = LoggerFactory.getLogger(Q2Dao.class);
	public Album findAlbum(String title) {
		return (Album) getCurrentSession().createCriteria (Album.class)
								.add(Restrictions.eq ("title", title))
								.uniqueResult();
	}
	public int createAlbum(Album album) {
		return (int) getCurrentSession().save(album);
	}
	public Song findSong(String name) {
		return (Song) getCurrentSession().createCriteria (Song.class)
				.add(Restrictions.eq ("name", name))
				.uniqueResult();
	}
	public int createSong(Song song) {
		return (int) getCurrentSession().save(song);
	}
	public boolean addSongToAlbum (String songName, String albumTitle)	{
		Song	song	= findSong (songName);
		Album	album	= findAlbum(albumTitle);
		if (song == null || album == null)	{
			return false;
		}
		album.getSongs().add(song);	// only add one works, no need to add both
		return true;
	}
	@SuppressWarnings("unchecked")
	public Set<Album> findAlbumWithSongs(String title) {
		return new HashSet<Album>(
					getCurrentSession().createQuery ("From Album a " +
										"join fetch a.songs s " +
										"where a.title = :title")
									.setString("title", title)
									.list());
	}
	@SuppressWarnings("unchecked")
	public List<Product> findPageOfProducts (String companyName, int startRow, int maxNumRows)	{
		return getCurrentSession().getNamedQuery("product.page")
				/*
				return getCurrentSession().createQuery("From Product p " +
										"join fetch p.company c " +
										"where c.name = :name " +
										"order by p.name")
										*/
							.setString("name",companyName)
							.setFirstResult(startRow)
							.setMaxResults(maxNumRows)
							.list();
	}
	@SuppressWarnings("unchecked")
	public List<Product> findProducts (long companyId)	{
		return getCurrentSession().createQuery("From Product p " +
										"join fetch p.company c " +
										"where c.name = :name " +
										"order by p.name")
							.setLong("id",companyId)
							.list();
	}
	
}
