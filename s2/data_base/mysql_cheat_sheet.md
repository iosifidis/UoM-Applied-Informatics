# Σκονάκι MySQL

> Βοήθεια με εντολές SQL για αλληλεπίδραση με βάση δεδομένων MySQL

## MySQL διαδρομές στον δίσκο
* Mac             */usr/local/mysql/bin*
* Windows         */Program Files/MySQL/MySQL _version_/bin*
* Xampp           */xampp/mysql/bin*

## Προσθήκη mysql στο PATH

```bash
# Μόνο για την τρέχουσα συνεδρία
export PATH=${PATH}:/usr/local/mysql/bin
# Μόνιμη προσθήκη
echo 'export PATH="/usr/local/mysql/bin:$PATH"' >> ~/.bash_profile
```

Σε Windows - https://www.qualitestgroup.com/resources/knowledge-center/how-to-guide/add-mysql-path-windows/

## Είσοδος

```bash
mysql -u root -p
```

## Εμφάνιση χρηστών

```sql
SELECT User, Host FROM mysql.user;
```

## Δημιουργία χρήστη

```sql
CREATE USER 'someuser'@'localhost' IDENTIFIED BY 'somepassword';
```

## Εκχώρηση όλων των δικαιωμάτων σε όλες τις βάσεις δεδομένων

```sql
GRANT ALL PRIVILEGES ON * . * TO 'someuser'@'localhost';
FLUSH PRIVILEGES;
```

## Εμφάνιση εκχωρήσεων

```sql
SHOW GRANTS FOR 'someuser'@'localhost';
```

## Αφαίρεση εκχωρήσεων

```sql
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'someuser'@'localhost';
```

## Διαγραφή χρήστη

```sql
DROP USER 'someuser'@'localhost';
```

## Έξοδος

```sql
exit;
```

## Εμφάνιση βάσεων δεδομένων

```sql
SHOW DATABASES
```

## Δημιουργία βάσης δεδομένων

```sql
CREATE DATABASE acme;
```

## Διαγραφή βάσης δεδομένων pamak

```sql
DROP DATABASE pamak;
```

## Επιλογή βάσης δεδομένων pamak

```sql
USE pamak;
```

## Δημιουργία πίνακα users

```sql
CREATE TABLE users(
id INT AUTO_INCREMENT,
   first_name VARCHAR(100),
   last_name VARCHAR(100),
   email VARCHAR(50),
   password VARCHAR(20),
   location VARCHAR(100),
   dept VARCHAR(100),
   is_admin TINYINT(1),
   register_date DATETIME,
   PRIMARY KEY(id)
);
```

## Διγραφή πίνακα

```sql
DROP TABLE tablename;
```

## Εμφάνιση πινάκων

```sql
SHOW TABLES;
```

## Εισαγωγή γραμμής / Εγγραφής

```sql
INSERT INTO users (first_name, last_name, email, password, location, dept, is_admin, register_date) values ('Brad', 'Traversy', 'brad@gmail.com', '123456','Massachusetts', 'development', 1, now());
```

## Εισαγωγή πολλαπλών γραμμών

```sql
INSERT INTO users (first_name, last_name, email, password, location, dept,  is_admin, register_date) values ('Fred', 'Smith', 'fred@gmail.com', '123456', 'New York', 'design', 0, now()), ('Sara', 'Watson', 'sara@gmail.com', '123456', 'New York', 'design', 0, now()),('Will', 'Jackson', 'will@yahoo.com', '123456', 'Rhode Island', 'development', 1, now()),('Paula', 'Johnson', 'paula@yahoo.com', '123456', 'Massachusetts', 'sales', 0, now()),('Tom', 'Spears', 'tom@yahoo.com', '123456', 'Massachusetts', 'sales', 0, now());
```

## Εντολή Select

```sql
SELECT * FROM users;
SELECT first_name, last_name FROM users;
```

## Συνθήκη Where

```sql
SELECT * FROM users WHERE location='Massachusetts';
SELECT * FROM users WHERE location='Massachusetts' AND dept='sales';
SELECT * FROM users WHERE is_admin = 1;
SELECT * FROM users WHERE is_admin > 0;
```

## Διαγραφή γραμμής

```sql
DELETE FROM users WHERE id = 6;
```

## Ενημέρωση γραμμών

```sql
UPDATE users SET email = 'iefstathios@gmail.com' WHERE id = 2;

```

## Προσθήκη νέας στήλης

```sql
ALTER TABLE users ADD age VARCHAR(3);
```

## Τροποποίηση στήλης

```sql
ALTER TABLE users MODIFY COLUMN age INT(3);
```

## Ταξινόμηση με Order By

```sql
SELECT * FROM users ORDER BY last_name ASC;
SELECT * FROM users ORDER BY last_name DESC;
```

## Συνδυασμός στηλών

```sql
SELECT CONCAT(first_name, ' ', last_name) AS 'Name', dept FROM users;

```

## Επιλογή διακριτών γραμμών (δεν εμφανίζει διπλότυπα)

```sql
SELECT DISTINCT location FROM users;

```

## Επιλογή εύρους με την Between

```sql
SELECT * FROM users WHERE age BETWEEN 20 AND 30;
```

## Αναζήτηση με την Like

```sql
SELECT * FROM users WHERE dept LIKE 'd%';
SELECT * FROM users WHERE dept LIKE 'dev%';
SELECT * FROM users WHERE dept LIKE '%t';
SELECT * FROM users WHERE dept LIKE '%e%';
```

## Αναζήτηση με Not Like

```sql
SELECT * FROM users WHERE dept NOT LIKE 'd%';
```

## Υπαρξιακό τελεστή IN

```sql
SELECT * FROM users WHERE dept IN ('design', 'sales');
```

## Δημιουργία και αφαίρεση Index

```sql
CREATE INDEX LIndex On users(location);
DROP INDEX LIndex ON users;
```

## Νέος πίνακας με ξένα κλειδιά

```sql
CREATE TABLE posts(
id INT AUTO_INCREMENT,
   user_id INT,
   title VARCHAR(100),
   body TEXT,
   publish_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY(id),
   FOREIGN KEY (user_id) REFERENCES users(id)
);
```

## Προσθήκη δεδομένων στον πίνακα Posts

```sql
INSERT INTO posts(user_id, title, body) VALUES (1, 'Post One', 'This is post one'),(3, 'Post Two', 'This is post two'),(1, 'Post Three', 'This is post three'),(2, 'Post Four', 'This is post four'),(5, 'Post Five', 'This is post five'),(4, 'Post Six', 'This is post six'),(2, 'Post Seven', 'This is post seven'),(1, 'Post Eight', 'This is post eight'),(3, 'Post Nine', 'This is post none'),(4, 'Post Ten', 'This is post ten');
```

## INNER JOIN (εσωτερική ένωση)

```sql
SELECT
  users.first_name,
  users.last_name,
  posts.title,
  posts.publish_date
FROM users
INNER JOIN posts
ON users.id = posts.user_id
ORDER BY posts.title;
```

## Νέος πίνακας με 2 ξένα κλειδιά

```sql
CREATE TABLE comments(
	id INT AUTO_INCREMENT,
    post_id INT,
    user_id INT,
    body TEXT,
    publish_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) references users(id),
    FOREIGN KEY(post_id) references posts(id)
);
```

## Προσθήκη δεδομένων στον πίνακα Comments

```sql
INSERT INTO comments(post_id, user_id, body) VALUES (1, 3, 'This is comment one'),(2, 1, 'This is comment two'),(5, 3, 'This is comment three'),(2, 4, 'This is comment four'),(1, 2, 'This is comment five'),(3, 1, 'This is comment six'),(3, 2, 'This is comment six'),(5, 4, 'This is comment seven'),(2, 3, 'This is comment seven');
```

## Left Join (δεξιά ένωση)

```sql
SELECT
comments.body,
posts.title
FROM comments
LEFT JOIN posts ON posts.id = comments.post_id
ORDER BY posts.title;

```

## Ένωση πολλαπλών πινάκων

```sql
SELECT
comments.body,
posts.title,
users.first_name,
users.last_name
FROM comments
INNER JOIN posts on posts.id = comments.post_id
INNER JOIN users on users.id = comments.user_id
ORDER BY posts.title;

```

## Συναρτήσεις συνάθροισης

```sql
SELECT COUNT(id) FROM users;
SELECT MAX(age) FROM users;
SELECT MIN(age) FROM users;
SELECT SUM(age) FROM users;
SELECT UCASE(first_name), LCASE(last_name) FROM users;

```

## Ομαδοποίηση κατά (Group By)

```sql
SELECT age, COUNT(age) FROM users GROUP BY age;
SELECT age, COUNT(age) FROM users WHERE age > 20 GROUP BY age;
SELECT age, COUNT(age) FROM users GROUP BY age HAVING count(age) >=2;

```
