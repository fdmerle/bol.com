Feature: Check delivery cost with different orders
#ToDo Find 3 goods with sum of cost == 20
  Scenario Outline: Check delivery cost by adding goods to the basket

    Given I open bol page in "<Browser>"

    When I add into basket
      | <Good1> |
      | <Good2> |
      | <Good3> |

    And I navigate to basket
    Then Then delivery cost should be "<Delivery cost>"


    Examples:
      | Browser | Good1                                        | Good2                                                                 | Good3                                  | Delivery cost |
      | Chrome  | Filofax The Original Schrijfmap A4 Dark Aqua | Leuchtturm1917 notitieboekje leder hardcover master A4+ dotted cognac | Notitieboekje A6 Golden Retriever pups | Gratis        |
      | Chrome  | Combi agenda A5 week 2017-2018 16 maanden    | Notitieboekje A6 Golden Retriever pups                                | 100 Euro notitieblok                   | € 1,99        |
      | FireFox | Filofax The Original Schrijfmap A4 Dark Aqua |                                                                       |                                        | Gratis        |
      | FireFox | Combi agenda A5 week 2017-2018 16 maanden    |                                                                       |                                        | € 1,99        |

  Scenario Outline: Check if delivery cost will change if we will remove good from basket

    Given I open bol page in "<Browser>"
    When I add into basket
      | "<Good1>" |
      | "<Good2>" |
      | "<Good3>" |

    And I navigate to basket
    And I remove one good from basket
#
    Then Then delivery cost should be "<Delivery cost>"

    Examples:
      | Browser | Good1                                     | Good2                                  | Good3                                                                 | Delivery cost |
      | FireFox | Blond Amsterdam Ringband 23-rings (A-4) Rollerskate | Leitz Active Style 4-rings ringband - titanium blauw | Leitz Active Style 4-rings ringband - satijn zwart | € 1,99        |
