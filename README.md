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

03/01/2024

-HAPPY NEW YEAR


-Implemented the Magias(Spells) now a characther can have grimoire of spells which you can add or remove spells by passing the id of character and id of the spell
-the commits will be less common because the things i wanna do will maybe take some time to be 100% working

06/01/2024

-Boy oh boy, constraints were way harder than i thought, but i made it, for now i only add to Nivel Magia and Personagem(Spell Level and Charachter) Spells range from 0 to 9, 0 beign cantrips, characthers range from 1 to 20, tomorrow i will add on the other entities with numbers like Items and commit, maybe i will change the Exception handeler if my friends help me but this will take more time

09/01/2024

-Yeah... it took longer than i thought, some stuff happened and i was kinda stuck with the code, but i realized what was wrong(Programming is so fun XD), anyway item now have a mininum and maximum cost(0-200000 gold) and weight(0-250 kg)

11/01/2024

-Did you ever in the middle of doing something you realized, hey... i should have done other thing before this, well this happened today and while i was doing the attributes of Personagem i remembred that i didn't make the Pericias(Skills), so i did then, you can create and add by passing the name and the key attribute, for now i will assume the only skills displayed on the characther are the trained for the sake of better viewing


TODO

-Data persistence(i kinda did it with pgAdmin but i was dumb and put my password on the pgAdmin, so yeah... i will change afterwards)

-Upgrade the Personagem entity with more methods and attributes

-Relation between the entities(DONE)

-add the constraints(i put some but still have more to be add)

-Make a function where you can add feats and spells by name and the application will convert into the ID then add

-Validate some relationships, for example a pure barbarian can't have a lv 9 spell or a wizard feat, a wizard cant have a healing spell from a cleric, etc.(this i will think later if this is actually needed since platforms like roll20 trust you will not do such things)

-Create a function to calculate the total bonus to the skill checks

-Documentation
