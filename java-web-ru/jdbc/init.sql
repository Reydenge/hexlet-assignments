DROP TABLE IF EXISTS articles;

CREATE TABLE articles (
  id bigint,
  title varchar(255),
  body text
);

INSERT INTO articles
  (id, title, body)
VALUES
  (8, 'The Man Within', 'Every flight begins with a fall.'),
  (92, 'Consider the Lilies', 'The things I do for love.'),
  (17, 'The Lathe of Heaven', 'Things are not always as they seemed, much that may seem evil can be good.'),
  (15, 'Clouds of Witness', 'Why is it that when one man builds a wall, the next man immediately needs to know what`s on the other side?'),
  (45, 'Eyeless in Gaza', 'There are no heroes...in life, the monsters win.'),
  (16, 'Oh! To be in England', 'All dwarfs are bastards in their father`s eyes'),
  (62, 'A Passage to India', 'Power is a curious thing. Who lives, Who dies. Power resides where men believe it resides. It is a trick, A shadow on the wall.'),
  (52, 'Tender Is the Night', 'Power is a curious thing. Who lives, Who dies. Power resides where men believe it resides. It is a trick, A shadow on the wall.'),
  (88, 'The Last Enemy', 'Knowledge could be more valuable than gold, more deadly than a dagger.'),
  (66, 'I Know Why the Caged Bird Sings', 'When the snows fall and the white winds blow, the lone wolf dies but the pack survives.'),
  (71, 'East of Eden', 'Give me honorable enemies rather than ambitious ones, and I`ll sleep more easily by night.'),
  (30, 'The Moving Toyshop', 'Why is it that when one man builds a wall, the next man immediately needs to know what`s on the other side?'),
  (53, 'Death Be Not Proud', 'Laughter is poison to fear.'),
  (31, 'Dying of the Light', 'Give me honorable enemies rather than ambitious ones, and I`ll sleep more easily by night.'),
  (56, 'The Monkey`s Raincoat', 'Do the dead frighten you?'),
  (12, 'The World, the Flesh and the Devil', 'When the snows fall and the white winds blow, the lone wolf dies but the pack survives.'),
  (34, 'To a God Unknown', 'Fear cuts deeper than swords.'),
  (24, 'Fear and Trembling', 'A lion doesn`t concern itself with the opinion of sheep.'),
  (27, 'A Time to Kill', 'Do the dead frighten you?'),
  (69, 'That Good Night', 'Summer will end soon enough, and childhood as well.'),
  (21, 'The Mermaids Singing', 'Do the dead frighten you?'),
  (4, 'Down to a Sunless Sea', 'Winter is coming.'),
  (59, 'Cover Her Face', 'Knowledge could be more valuable than gold, more deadly than a dagger.'),
  (57, 'Let Us Now Praise Famous Men', 'Why is it that when one man builds a wall, the next man immediately needs to know what`s on the other side?'),
  (99, 'A Time of Gifts', 'Summer will end soon enough, and childhood as well.'),
  (73, 'Precious Bane', 'And I have a tender spot in my heart for cripples and bastards and broken things.'),
  (35, 'The Proper Study', 'There are no heroes...in life, the monsters win.'),
  (96, 'In a Dry Season', 'Never forget who you are. The rest of the world won`t. Wear it like an armor and it can never be used against you.'),
  (38, 'Clouds of Witness', 'Hodor? Hodor.'),
  (90, 'The Moving Toyshop', 'Never forget who you are. The rest of the world won`t. Wear it like an armor and it can never be used against you.'),
  (48, 'Edna O`Brien', 'Winter is coming.'),
  (85, 'Time of our Darkness', 'The North remembers.'),
  (75, 'The Yellow Meads of Asphodel', 'Once you’ve accepted your flaws, no one can use them against you.'),
  (33, 'Unweaving the Rainbow', 'The things I do for love.'),
  (14, 'A Monstrous', 'Winter is coming.'),
  (18, 'Fair Stood the Wind for France', 'There are no heroes...in life, the monsters win.'),
  (1, 'Tiger! Tiger!', 'And I have a tender spot in my heart for cripples and bastards and broken things.'),
  (70, 'Tiger! Tiger!', 'Things are not always as they seemed, much that may seem evil can be good.'),
  (25, 'To Your Scattered Bodies Go', 'Every flight begins with a fall.'),
  (80, 'From Here to Eternity', 'Fear cuts deeper than swords.'),
  (47, 'Bury My Heart at Wounded Knee', 'Every flight begins with a fall.'),
  (28, 'Where Angels Fear to Tread', 'Knowledge could be more valuable than gold, more deadly than a dagger.'),
  (20, 'Vile Bodies', 'Things are not always as they seemed, much that may seem evil can be good.'),
  (5, 'The Line of Beauty', 'The North remembers.'),
  (49, 'From Here to Eternity', 'Nothing burns like the cold.'),
  (36, 'To Your Scattered Bodies Go', 'A lion doesn`t concern itself with the opinion of sheep.'),
  (51, 'Time To Murder And Create', 'Never forget who you are. The rest of the world won`t. Wear it like an armor and it can never be used against you.'),
  (93, 'The Last Temptation', 'The North remembers.'),
  (64, 'Stranger in a Strange Land', 'When you play a game of thrones you win or you die.'),
  (63, 'This Side of Paradise', 'Winter is coming.'),
  (44, 'A Glass of Blessings', 'Laughter is poison to fear.'),
  (74, 'Let Us Now Praise Famous Men', 'Once you’ve accepted your flaws, no one can use them against you.'),
  (72, 'To a God Unknown', 'And I have a tender spot in my heart for cripples and bastards and broken things.'),
  (26, 'The Wives of Bath', 'Nothing burns like the cold.'),
  (97, 'The Waste Land', 'Why is it that when one man builds a wall, the next man immediately needs to know what`s on the other side?'),
  (77, 'Blue Remembered Earth', 'All dwarfs are bastards in their father`s eyes'),
  (91, 'Alone on a Wide, Wide Sea', 'Give me honorable enemies rather than ambitious ones, and I`ll sleep more easily by night.'),
  (58, 'That Hideous Strength', 'The things I do for love.'),
  (13, 'A Monstrous Regiment of Women', 'Winter is coming.'),
  (100, 'Of Human Bondage', 'Give me honorable enemies rather than ambitious ones, and I`ll sleep more easily by night.'),
  (40, 'The Little Foxes', 'And I have a tender spot in my heart for cripples and bastards and broken things.'),
  (46, 'To Sail Beyond the Sunset', 'Never forget who you are. The rest of the world won`t. Wear it like an armor and it can never be used against you.'),
  (98, 'The Road Less Traveled', 'Winter is coming.'),
  (37, 'Unweaving the Rainbow', 'Things are not always as they seemed, much that may seem evil can be good.'),
  (67, 'A Time of Gifts', 'Do the dead frighten you?'),
  (89, 'Bury My Heart at Wounded Knee', 'Nothing burns like the cold.'),
  (41, 'Look to Windward', 'Nothing burns like the cold.'),
  (23, 'No Country for Old Men', 'Summer will end soon enough, and childhood as well.'),
  (6, 'Absalom, Absalom!', 'Never forget who you are. The rest of the world won`t. Wear it like an armor and it can never be used against you.'),
  (86, 'In Dubious Battle', 'A lion doesn`t concern itself with the opinion of sheep.'),
  (42, 'When the Green Woods Laugh', 'A lion doesn`t concern itself with the opinion of sheep.'),
  (50, 'This Side of Paradise', 'When you play a game of thrones you win or you die.'),
  (95, 'Time To Murder And Create', '... a mind needs books as a sword needs a whetstone, if it is to keep its edge.'),
  (9, 'The House of Mirth', 'Winter is coming.'),
  (54, 'Quo Vadis', 'Laughter is poison to fear.'),
  (11, 'A Monstrous Regiment', 'There are no heroes...in life, the monsters win.'),
  (39, 'A Passage to India', 'When you play a game of thrones you win or you die.'),
  (61, 'Françoise Sagan', 'Laughter is poison to fear.'),
  (2, 'The Grapes of Wrath', 'Give me honorable enemies rather than ambitious ones, and I`ll sleep more easily by night.'),
  (82, 'Number the Stars', 'Summer will end soon enough, and childhood as well.'),
  (19, 'The Violent Bear It Away', 'Do the dead frighten you?'),
  (43, 'Quo Vadis', 'The North remembers.'),
  (29, 'Surprised by Joy', 'When you play a game of thrones you win or you die.'),
  (94, 'Consider Phlebas', '... a mind needs books as a sword needs a whetstone, if it is to keep its edge.'),
  (55, 'Nine Coaches Waiting', '... a mind needs books as a sword needs a whetstone, if it is to keep its edge.'),
  (32, 'The Wealth of Nations', 'Once you’ve accepted your flaws, no one can use them against you.'),
  (84, 'The Painted Veil', 'Give me honorable enemies rather than ambitious ones, and I`ll sleep more easily by night.'),
  (65, 'Look to Windward', 'Nothing burns like the cold.'),
  (78, 'A Scanner Darkly', 'Knowledge could be more valuable than gold, more deadly than a dagger.'),
  (60, 'As I Lay Dying', 'All dwarfs are bastards in their father`s eyes'),
  (79, 'The Moving Toyshop', 'Laughter is poison to fear.'),
  (10, 'Vile Bodies', 'Winter is coming.'),
  (68, 'Butter In a Lordly Dish', 'Winter is coming.'),
  (81, 'Where Angels Fear to Tread', '... a mind needs books as a sword needs a whetstone, if it is to keep its edge.'),
  (3, 'Many Waters', 'Fear cuts deeper than swords.'),
  (76, 'A Handful of Dust', 'Power is a curious thing. Who lives, Who dies. Power resides where men believe it resides. It is a trick, A shadow on the wall.'),
  (22, 'East of Eden', 'There are no heroes...in life, the monsters win.'),
  (7, 'In Dubious Battle', 'Some old wounds never truly heal, and bleed again at the slightest word.'),
  (87, 'The Last Enemy', 'Things are not always as they seemed, much that may seem evil can be good.');
