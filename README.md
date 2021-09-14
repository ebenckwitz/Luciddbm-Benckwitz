luciddb
=======

LucidDB has had a long run as the first pure play open source column store database.

However, with no commercial sponsors and no ongoing community activity it's time to OFFICIALLY shut the doors.

There will be no future code, or binary releases (this repository may dissapear at some point) of luciddb.  All assets (wiki, issues, etc) will likely start coming down as well over the course of 2014.

Appreciate all the effort by all those involved with LucidDB.

Optiq, has given home and new life to portions of the LucidDB codebase.  If you're interested in speaking SQL to NoSQL sources please checkout the Optiq project.  https://github.com/julianhyde/optiq

```
addons:
  sonarcloud:
    organization: "ethanbenckwitz"
    token:
      secure: "**************************" # encrypted value of your token

script:
  # the following command line builds the project, runs the tests with coverage and then execute the SonarCloud analysis
  - sonar-scanner

^^ idk what but we might need this
```
