Feature: Post endpoint test

Scenario: Verificar um usuario
    Given url 'https://jsonplaceholder.typicode.com'
    And path 'posts'
    And param userID = 1
    When method get
    Then status 200
   # And match responseType == 'json'
   # * print "RESPONSE:", response [0].title 
    And assert response.length > 1