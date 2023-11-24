-- database javaroomdb

-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************
DO
$do$
BEGIN 
IF NOT EXISTS( SELECT * from INFORMATION_SCHEMA.Tables WHERE Table_name = 'users')  THEN
    --users (name is pluralized because 'user' is a SQL keyword)
    CREATE TABLE users (
                       user_id SERIAL,
                       username varchar(50) NOT NULL UNIQUE,
                       password_hash varchar(200) NOT NULL,
                       role varchar(50) NOT NULL,
                       name varchar(50) NOT NULL,
                       email varchar(200) NOT NULL,
                       address varchar(100) NULL,
                       city varchar(50) NULL,
                       state_code char(2) NULL,
                       zip varchar(5) NULL,
                       CONSTRAINT PK_user PRIMARY KEY (user_id)
    );

    INSERT INTO users (username,password_hash,role, name, email, address, city, state_code, zip)
    VALUES
        ('user', '$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_USER',  'Miyoko Yamakawa', 'miyoko.yamakawa123@gmail.com', '4800 Irvine Blvd', 'Irvine', 'CA', '92620'),
        ('admin','$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_ADMIN', 'yamako','yamakodev@gmail.com', '4800 Irvine Blvd', 'Irvine', 'CA', '92620');

end if;

IF NOT EXISTS (SELECT * from INFORMATION_SCHEMA.Tables WHERE Table_name = 'library') THEN
    CREATE TABLE library (
                        library_id SERIAL,
                        owner_id int NOT NULL,
                        name varchar(50) NOT NULL,
                        description varchar(200),
                        CONSTRAINT PK_library PRIMARY KEY (library_id),
                        CONSTRAINT FK_library_owner FOREIGN KEY (owner_id) REFERENCES users(user_id)
    );

    INSERT INTO library ( owner_id, name, description)
    VALUES
        (1, 'OCA', 'Oracle Certified Associate Java Programmer exam prep video library');
end if;

IF NOT EXISTS (SELECT * from INFORMATION_SCHEMA.Tables WHERE Table_name = 'video') THEN
    CREATE TABLE video (
                        video_id SERIAL,
                        library_id int NOT NULL,
                        name varchar(50) NOT NULL,
                        url varchar(200) NOT NULL,
                        thumbnail varchar(200) NOT NULL,
                        title varchar(50) NOT NULL,
                        comment varchar,
                        selected boolean NOT NULL,
                        CONSTRAINT PK_video PRIMARY KEY (video_id),
                        CONSTRAINT FK_library FOREIGN KEY (library_id) REFERENCES library(library_id)
    );

    INSERT INTO video ( library_id, name, url, thumbnail, title, comment, selected)
    VALUES
        (1, 'predicate', 'https://d3h1vu2agxyise.cloudfront.net/Predicate28.mp4', 'https://d3h1vu2agxyise.cloudfront.net/parchment2.jpg', 'Predicate', '', TRUE),
        (1, 'try-catch-finally', 'https://d3h1vu2agxyise.cloudfront.net/TryCatchFinally37_1.mp4', 'https://d3h1vu2agxyise.cloudfront.net/buonconvento.jpg', 'try-catch', '', TRUE),
        (1, 'polymorphism', 'https://d3h1vu2agxyise.cloudfront.net/Polymorphism36.mp4', 'https://d3h1vu2agxyise.cloudfront.net/parchment4.jpg', 'Polymorphism', '', TRUE),
        (1, 'override', 'https://d3h1vu2agxyise.cloudfront.net/Override21.mp4', 'https://d3h1vu2agxyise.cloudfront.net/ruins-in-the-forest-2021-08-26-17-52-15-utc.jpg', 'Inheritance', '', TRUE),
        (1, 'lambda', 'https://d3h1vu2agxyise.cloudfront.net/Lambda27.mp4', 'https://d3h1vu2agxyise.cloudfront.net/majestic-medieval-tower-of-the-ribeaupierre-castle-2021-09-04-11-59-49-utc.jpg', 'Lambda', '', TRUE),
        (1, 'unary-operator', 'https://d3h1vu2agxyise.cloudfront.net/UnaryOperators.mp4', 'https://d3h1vu2agxyise.cloudfront.net/eilean-donan-castle-scotland-2023-09-19-04-16-57-utc.jpg', 'Unary-Operator', '', TRUE),
        (1, 'super', 'https://d3h1vu2agxyise.cloudfront.net/Super22.mp4', 'https://d3h1vu2agxyise.cloudfront.net/loarre-castle-in-spain-2021-09-02-04-03-29-utc.jpg', 'Super', '', TRUE),
        (1, 'instanceof', 'https://d3h1vu2agxyise.cloudfront.net/instanceof31.mp4', 'https://d3h1vu2agxyise.cloudfront.net/parchment1.jpg', 'instanceof', '', TRUE),
        (1, 'wrapper-primitive', 'https://d3h1vu2agxyise.cloudfront.net/WrapperPrimitive.mp4', 'https://d3h1vu2agxyise.cloudfront.net/parchment3.jpg', 'Wrapper', '', TRUE),
        (1, 'loop', 'https://d3h1vu2agxyise.cloudfront.net/Loops35.mp4', 'https://d3h1vu2agxyise.cloudfront.net/old-european-street.jpg', 'Loop', '', TRUE),
        (1, 'ArrayToString', 'https://d3h1vu2agxyise.cloudfront.net/ArrayToString.mp4', 'https://d3h1vu2agxyise.cloudfront.net/witch-accessories-2021-08-26-15-34-56-utc.jpg', 'Array-To-String', '', TRUE),
        (1, 'switch', 'https://d3h1vu2agxyise.cloudfront.net/Switch.mp4', 'https://d3h1vu2agxyise.cloudfront.net/witchcraft.jpg', 'Switch', '', TRUE);
end if;
END
$do$

