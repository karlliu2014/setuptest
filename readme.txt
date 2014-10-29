q1-dao is creared for the purpose of expose q1's dao component only
It's created as a java project. Converted to Maven
Copied the compoments from q1.
added a q1-context-dao.xml to just expose the component scan base-package.
The unit test works.
And it's accessible from q1 and Rest2.

Added AOP and it works when called from q1 but not q2 while q1 doesn't have aop and q2 does. Could that be a reason? as q2 specify the pointcuts only point to itself.
Replaced Q1Dao by Q2Dao after changed schema of album_song. Orignally it has it's own id but then removed and use compound key. After AlbumSong.java is gone.

It's now in Git for practice
