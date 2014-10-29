package com.pivotal.q1.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pivotal.q1.model.Album;
import com.pivotal.q1.model.Product;
import com.pivotal.q1.model.Song;

public class Q2DaoTest extends BaseTest	{
	private static final String	songName	= "Not Existing song";
	private static final String albumTitle	= "Not existing album";
	
	@Autowired
	private Q2Dao dao;
	
	@Before
	public void setUp() throws Exception {
		assertNotNull (dao);
	}

	@After
	public void tearDown() throws Exception {
	}
	/*
	
	@Test
	public void testCreateAlbum() {
		assertTrue (dao.createAlbum(createAlbum()) > 0);
	}
	@Test
	public void testFindAlbum() {
		assertNull (dao.findAlbum(albumTitle));
		testCreateAlbum();
		assertNotNull (dao.findAlbum(albumTitle));
	}
	*/
	@Test
	public void testCreateSong ()	{
		assertTrue (dao.createSong(createSong()) > 0);
	}
	@Test
	public void testFindSong ()	{
		assertNull (dao.findSong(songName));
		testCreateSong();
		Song song = dao.findSong(songName);
		assertNotNull (song);
		assertNotNull (song.getName());
		assertTrue (song.getName().length() > 0);
	}
	/*
	
	@Test
	public void testAddSongToAlbum ()	{
		assertTrue (dao.createSong(createSong()) > 0);
		assertTrue (dao.createAlbum(createAlbum()) > 0);
		assertTrue (dao.addSongToAlbum(songName, albumTitle));
	}
	
	@Test
	public void testFindAlbumWithSongs ()	{
		testAddSongToAlbum ();
		Set<Album> albums = dao.findAlbumWithSongs(albumTitle);
		assertNotNull (albums);
		assertTrue (albums.size()>0);
		for (Album album : albums)	{
			Set<Song> songs = album.getSongs();
			assertNotNull (songs);
			assertTrue (songs.size() > 0);	
			for (Song song : songs)	{
				if (song.getName().equalsIgnoreCase(songName))	{
					return;
				}
			}
		}
		fail();
	}
	*/
	private Album createAlbum ()	{
		Album album = new Album();
		album.setArtist("Somebody");
		album.setTitle(albumTitle);
		return album;
	}
	private Song createSong ()	{
		Song song = new Song();
		song.setName(songName);
		song.setDuration(10);
		return song;
	}
	private void printOutProducts (List<Product> products)	{
		for (Product product: products)	{
			System.out.println (product.getName());
		}
	}
	@Test
	public void testFindPageOfProducts ()	{
		List<Product> products = dao.findPageOfProducts("IBM", 0, 3);
		assertNotNull (products);
		assertEquals (3, products.size());
		printOutProducts (products);
		
		products = dao.findPageOfProducts("IBM", 3, 3);
		assertNotNull (products);
		assertEquals (3, products.size());
		printOutProducts (products);

		products = dao.findPageOfProducts("IBM", 6, 3);
		assertNotNull (products);
		assertEquals (3, products.size());
		printOutProducts (products);

		products = dao.findPageOfProducts("IBM", 9, 3);
		assertNotNull (products);
		assertEquals (2, products.size());
		printOutProducts (products);
	}
}
