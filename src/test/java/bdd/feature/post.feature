Feature: Post endpoint test

@Post
Scenario: Verificar um usuario
    Given url 'https://jsonplaceholder.typicode.com'
    And path 'posts'
    And param userID = 1
    When method get
    Then status 200
   # And match responseType == 'json'
   # * print "RESPONSE:", response [0].title 
    And assert response.length > 1

@Post
Scenario: Verificar un usuario en especifico tipo 2
    Given url 'https://jsonplaceholder.typicode.com'
    And path 'posts'
    And param userId = 2
    When method get
    Then status 200
    And assert response.length > 1
    And match responseType == 'json'
    * print "RESPONSE:", response    