# assignment
assignment one 

add universe
endpoint:
rest/universe/universe
request:

{
  "univName": “planet”,
  "univDescription": "hello"
}


add family with out universe id::it will create a family 
endpoint:
rest/families/family
request:

{
 "name": "FamilyOne”,
"description": "hello"
}

add family and add it to universe ::it will create a family and link this family with Unvierse ,If any of the Unvierse doesn't exist it wont create any family.
endpoint:
rest/families/addFamily
request:

{
  "name": "FamilyThree",
  "univIds": ["UNIV-4375671e-aa07-44fe-85d5-00f425416500”,”UNIV-4375671e-aa07-44fe-85d5-00f425416500”],
  "description": "hello"
}


to link a family with a universe::It will link only if both universe and family exist 
endpoint:
rest/univFamilies/univfamily
request:
{
  "universeId": "UNIV-1402cc41-e9f4-4de8-8e43-fe05a0c7842b",
  "familyId": "FAM-00c84145-0d3c-4101-a5bc-f61d31eb7246"
}


add person::it will create a person only if the family and the universe exist and they are link to each other
endpoint:
rest/people/person
request:

{
  "name": “apurba saha“,
  "power": 100,
  "univId":"UNIV-4375671e-aa07-44fe-85d5-00f425416500",
  "familyId":"FAM-15b61a6d-a0dd-4a97-ba77-bb6523ee4f0e"
}



endpoint to get all families in a universe
endpoint:
/familiesOfUniverse/{id}
id=universe id

endpoint to get power of a family grouped by universe
endpoint:
/familyPower/{id}
id=family id

endpoint to balance family
endpoint:
/balanceFamily/{id}
id=family id

after first run change spring.jpa.hibernate.ddl-auto=update at appliaction.properties
