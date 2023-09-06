INSERT INTO
    video (id, title, duration, cover_url, file_url, excerpt, type)
VALUES
    (1, 'Spiderman', '120', '/images/covers/movies/spiderman.jpg', '/videos/movies/spiderman.mp4', 'Spiderman - excerpt here', 'Movie'),
    (2, 'Limitless', '120', '/images/covers/movies/limitless.jpg', '/videos/movies/limitless.mp4', 'Limitless - excerpt here', 'Movie'),
    (3, 'I Am Legend', '120', '/images/covers/movies/iamlegend.jpg', '/videos/movies/iamlegend.mp4', 'I Am Legend - excerpt here', 'Movie'),
    (4, 'Cyberwar', '120', '/images/covers/documentaries/cyberwar.jpg', '/videos/movies/cyberwar.mp4', 'Cyberwar - excerpt here', 'Documentary'),
    (5, 'Two and a half men', '120', '/images/covers/movies/twoandahalfmen.jpg', '/videos/movies/twoandahalfmen.mp4', 'Two and a half men - excerpt here', 'Serie');

INSERT INTO
    category (id, title)
VALUES
    (1, 'Action'),
    (2, 'Comedy'),
    (3, 'Drama'),
    (4, 'Mystery'),
    (5, 'Romance'),
    (6, 'Science-fiction'),
    (7, 'Thriller'),
    (8, 'Western');

INSERT INTO
    video_category (video_pk, category_pk)
VALUES
    (1, 1),
    (1, 6),
    (2, 1),
    (2, 6),
    (3, 1),
    (3, 3),
    (3, 7),
    (4, 4),
    (5, 2);