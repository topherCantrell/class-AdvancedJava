JUnit must be added to the project. Click on an error then "Fix Project Setup" and let Eclipse add JUnit.

Adding Derby to the path:

```
set path=%path%;"c:\Program Files\java\jdk1.8.0_171\db\bin"
```

Creating the database

```
ij
ij> connect 'jdbc:derby:dbpets;create=true';
ij> run 'Pets.sql';
ij> exit;
```

24:35 Solution