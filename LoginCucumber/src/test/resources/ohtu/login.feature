Feature: User can log in with valid username/password-combination

    Scenario: user can login with correct password
       Given command login is selected
       When  username "pekka" and password "akkep123" are entered
       Then  system will respond with "logged in"

    Scenario: user can't login with wrong password
       Given command login is selected
       When  username "pekka" and password "kebab123" are entered
       Then  system will respond with "wrong username or password"


    Scenario: user can't login with wrong username
       Given command login is selected
       When  username "pekoz" and password "ekkap123" are entered
       Then  system will respond with "wrong username or password"

