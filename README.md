Welcome, this is an personal project im working while learning Spring boot, is an application used to create and manage D&D 5e character sheets
im gonna upgrade the app as times goes by until it becomes a full stack and functional application, but for now im focusing on the back-end since is my
area of interest

Changelog

16/12/2023
-Creation of the repository with the Personagem(Character) entity and it's CRUD methods

17/12/2023
-Creation of the Item entity and methods, all working

18/12/2023
-Creation of the habilidade(feats) entity and methods, all working
-Creation of the magia(spell) entity and methods, all methods except findById are working

26/12/2023
-MERRY CHRISTMAS
-Now Personagens(Characters) can have Habilidades(feats), you can add and deleting them by providing the ID of the character and the feat ID, the same logic will be used to Items and Magias(Spells)


TODO
-Data persistence
-Rearrange the tables row order
-Upgrade the Personagem entity with more methods and attributes
-Relation between the entities
-Make a function where you can add feats and spells by name and the application will convert in ID then add
-Validate some relationships, for example a pure barbarian can't have a lv 9 spell or a wizard feat, etc
