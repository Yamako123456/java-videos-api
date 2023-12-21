package com.yamako.javavideosapi;

import com.yamako.javavideosapi.dao.LibraryDao;
import com.yamako.javavideosapi.dao.UserDao;
import com.yamako.javavideosapi.dao.VideoDao;
import com.yamako.javavideosapi.model.Library;
import com.yamako.javavideosapi.model.User;
import com.yamako.javavideosapi.model.Video;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Log
public class JavaVideosApiApplication implements CommandLineRunner {

	private VideoDao videoDao;
	private LibraryDao libraryDao;
	private UserDao userDao;

	public JavaVideosApiApplication(VideoDao videoDao, LibraryDao libraryDao, UserDao userDao) {
		this.videoDao = videoDao;
		this.libraryDao = libraryDao;
		this.userDao = userDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaVideosApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//testDao();
		testRest();
	}

	private void testRest() {
		log.info("XXXXXXXXX    Test Rest API -miyoko  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

	}
	private void testDao() {
		log.info("XXXXXXXXX    Test DAO -miyoko   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

		List<Video> videos = videoDao.getSelectedVideosByLibraryId(1);
		for (Video video: videos) {
			log.info(video.toString());
		}
		Video video = videoDao.getVideoById(9);
		log.info(video.toString());
		List<Library> libraries = libraryDao.getLibraryiesByName("O", true);
		for (Library library: libraries) {
			log.info(library.toString());
		}
		Library library = libraryDao.getLibraryById(2);
		log.info(library.toString());
		List<User> users = userDao.getUsers();
		for (User user: users) {
			log.info(user.toString());
		}
		User user = userDao.getUserById(2);
		log.info(user.toString());
	}

}
