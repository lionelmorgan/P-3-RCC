INSERT INTO user_roles VALUES (DEFAULT, 'USER');

INSERT INTO user_roles VALUES (DEFAULT, 'ADMIN');

INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL, USERNAME, PASSWORD, ROLE_ID)values('Admin', 'Istrator', 'adminUser@email.com', 'admin', '$2a$10$UCoYxwBAux02BsqnhaNRDeBAqcVsWWZTKB/lV3Qm8i8StQpXi62wi', 2);
--pass1234

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('Java I', 'Do you want to learn about Java? Start from the basics in this course for absolute Java beginners', 55.99, 10, 'https://i.ytimg.com/vi/r59xYe3Vyks/hqdefault.jpg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, SALE_PRICE, STOCK, IMAGE_URL) VALUES ('Java II', 'Do you know what a functional interface is? Then you''re ready for Java II!', 299.99, 190.99, 20, 'https://cosmolearning.org/images_dir/courses/809/profile-thumbnail-w300.jpg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('Java III', 'WARNING: DIFFICULTY MAXIMUM! DO NOT ATTEMPT', 499.99, 30, 'http://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/11/blog_Advanced-Java-Tutorial.jpg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('Spring I', 'Learn the Spring framework starting from the beginning', 9.99, 15, 'https://docs.spring.io/spring-cloud-sleuth/docs/current/reference/htmlsingle/favicon.ico')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, SALE_PRICE, STOCK, IMAGE_URL) VALUES ('Spring II', 'Spring into Spring II with intermediate topics and exercises', 11.99, 11.00, 12, 'https://d3mxt5v3yxgcsr.cloudfront.net/courses/2185/course_2185_image.png')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('Intro to Maven', 'Want to learn the Maven package manager?', 0.15, 6, 'https://miro.medium.com/max/640/1*hm5-eCLGCD5LmCWQM8cUDg.jpeg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, SALE_PRICE, STOCK, IMAGE_URL) VALUES ('How to use Git', 'Tired of main (final) (final) (final 2) (FINAL).java? Learn the Git VCS', 0.99, 0.90, 34, 'https://res.cloudinary.com/practicaldev/image/fetch/s--VsMB5n_5--/c_imagga_scale,f_auto,fl_progressive,h_900,q_auto,w_1600/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/p5002em7ykmkxqmonsp7.png')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('Guide to Angular', 'Learn the Angular framework fast and easy', 76.13, 530, 'https://miro.medium.com/max/3798/1*eOE7VhXBlqdIJ9weEdHbQQ.jpeg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('SQL I', 'Learning SQL? Start here', 12.98, 72, 'https://i.ytimg.com/vi/BPHAr4QGGVE/maxresdefault.jpg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, SALE_PRICE, STOCK, IMAGE_URL) VALUES ('SQL II', 'Want to become a database administrator? Take this course first', 99.99, 89.99, 33, 'https://i.ytimg.com/vi/M-55BmjOuXY/maxresdefault.jpg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('JavaScript Fundamentals', 'Learn the basics of JavaScript (which has nothing to do with Java!)', 59.99, 5, 'https://handsontable.com/blog/wp-content/uploads/2018/07/best-resources-to-learn-javascript.png')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('Jason''s Guide to JSON', 'Learn JSON from Jason', 9999.99, 49, 'https://st.depositphotos.com/2398521/2608/i/950/depositphotos_26089317-stock-photo-cute-small-dog.jpg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('TypeScript for Beginners', 'Want to learn TypeScript?', 0.01, 18, 'https://tutorialzine.com/media/2016/07/learn-typescript-in-30.png')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, SALE_PRICE, STOCK, IMAGE_URL) VALUES ('Beginner Python', 'Learn Python! (no snakes involved)', 15.00, 10.00, 7, 'https://pythonguides.com/wp-content/uploads/2020/11/Python-programming-for-the-absolute-beginner.png')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('Intermediate Python', 'Python for intermediate users', 24.99, 999, 'https://assets.datacamp.com/production/course_799/shields/original/shield_image_course_799_20200228-1-119xpm0?1582886778')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, SALE_PRICE, STOCK, IMAGE_URL) VALUES ('Advanced Python', 'Python for advanced users', 39.99, 39.98, 0, 'https://media.geeksforgeeks.org/wp-content/cdn-uploads/20210917204112/Top-10-Advance-Python-Concepts-That-You-Must-Know.png')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('The Agile Method', 'User stories, backlogs, etc.', 0.02, 2, 'https://lh4.googleusercontent.com/nW_yFs4Hu2IfSEEokyas2_gFESgctL2nWzQEJ2Vc8dr39HsbmppAmAqHlHK2F_mtsEsn4HQEVP8EH9A0mqFDQjU2KiVPldOAIH0u343jbBwm78MLPJw1tCk3DMyy606Y8bqUDq4')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('The Waterfall Method', 'Step by step', 0.03, 7, 'https://www.umsl.edu/~hugheyd/is6840/images/Waterfall_model.png')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('Microservices', 'Services, but micro', 100.00, 5, 'https://www.qentelli.com/sites/default/files/2021-06/guide%20to%20microservices-new.png')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, SALE_PRICE, STOCK, IMAGE_URL) VALUES ('HTML and CSS', 'Structured and styled', 56.99, 51.99, 19, 'https://miro.medium.com/max/1200/1*g_ZNK7Gnle7eg2lVk_jWnw.jpeg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('HTML and CSS Part 2', 'New tags and attributes', 57.99, 98, 'https://www.filepicker.io/api/file/5LVT41q4QGWKXAvJVLGv')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('HTML and CSS Part 3', 'More structure and more styling', 59.99, 23, 'https://i.ytimg.com/vi/1rbo_HHt5nw/maxresdefault.jpg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, SALE_PRICE, STOCK, IMAGE_URL) VALUES ('NodeJS', 'Use JavaScript outside the browser', 78.99, 45.99, 30, 'https://i.ytimg.com/vi/RLtyhwFtXQA/maxresdefault.jpg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('Rust', 'Learn Rust language', 13.99, 30, 'https://www.rust-lang.org/static/images/rust-social-wide.jpg')

INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, STOCK, IMAGE_URL) VALUES ('Ruby on Rails 101', 'Basics of Ruby on Rails', 11.13, 3, 'https://res.cloudinary.com/practicaldev/image/fetch/s--jvDLhx0b--/c_imagga_scale,f_auto,fl_progressive,h_420,q_auto,w_1000/https://dev-to-uploads.s3.amazonaws.com/i/cpcr5w0kgl6j94tss7n9.png')