CREATE TABLE user (
	user_email VARCHAR(50) PRIMARY KEY,
    user_password VARCHAR(50) NOT NULL,
    user_nickname VARCHAR(30) NOT NULL UNIQUE,
    user_img VARCHAR(500),
    user_date DATE DEFAULT(current_date),
    user_ent_yn CHAR(1) DEFAULT 'N',
    user_spotify_yn CHAR(1) DEFAULT 'N',
    user_gender VARCHAR(15),
    user_birth DATE NOT NULL,
    user_manager CHAR(1),
    user_enroll_date DATE,
    CONSTRAINT user_ent_yn_check CHECK (user_ent_yn IN ('Y', 'N')),
    CONSTRAINT user_spotify_yn_check CHECK (user_spotify_yn IN ('Y', 'N'))
);

CREATE TABLE music (
	music_code INT PRIMARY KEY AUTO_INCREMENT,
    music_name VARCHAR(100) NOT NULL,
    music_artist VARCHAR(100) NOT NULL,
    music_album_name VARCHAR(100),
    music_album_img VARCHAR(500),
    music_spotify_link VARCHAR(500)
);

CREATE TABLE playlist (
	pl_code INT PRIMARY KEY AUTO_INCREMENT,
    pl_title VARCHAR(100) NOT NULL,
    pl_img VARCHAR(500),
    pl_date DATE DEFAULT(current_date),
    pl_public_yn CHAR(1) DEFAULT 'N',
    user_email VARCHAR(50),
    FOREIGN KEY (user_email) REFERENCES user(user_email)
);

CREATE TABLE playlist_like (
	like_code INT PRIMARY KEY AUTO_INCREMENT,
    like_date DATE DEFAULT(current_date),
    user_email VARCHAR(50), 
    pl_code INT,
    FOREIGN KEY (user_email) REFERENCES user(user_email),
    FOREIGN KEY (pl_code) REFERENCES playlist(pl_code)
);

CREATE TABLE playlist_music (
	pm_code INT PRIMARY KEY AUTO_INCREMENT,
    pl_code INT,
    music_code INT,
    FOREIGN KEY (pl_code) REFERENCES playlist(pl_code),
    FOREIGN KEY (music_code) REFERENCES music(music_code)
);

CREATE TABLE tag (
	tag_code INT PRIMARY KEY AUTO_INCREMENT,
    tag_name VARCHAR(50) NOT NULL
);

CREATE TABLE playlist_tag (
	pl_tag_code INT PRIMARY KEY AUTO_INCREMENT,
	pl_code INT,
    tag_code INT,
    FOREIGN KEY (pl_code) REFERENCES playlist(pl_code),
    FOREIGN KEY (tag_code) REFERENCES tag(tag_code)
);

desc user;
desc playlist_like;
desc playlist_music;
desc music;
desc playlist;
desc tag;
desc playlist_tag;