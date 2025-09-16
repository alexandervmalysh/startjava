\echo 'Вся таблица'
SELECT *
  FROM jaegers
 ORDER BY model_name ASC;

\echo 'Не уничтоженные роботы'
SELECT *
  FROM jaegers
 WHERE status = 'Active'
 ORDER BY model_name ASC;

\echo 'Роботы серии Mark-1 и Mark-4'
SELECT *
  FROM jaegers
 WHERE mark IN ('1', '4')
 ORDER BY model_name ASC;

\echo 'Все роботы, кроме Mark-1 и Mark-4, сортировка по убыванию по столбцу mark'
SELECT *
  FROM jaegers
 WHERE mark NOT IN ('1', '4')
 ORDER BY mark DESC;

\echo 'Информация о самых старых роботах'
SELECT *
  FROM jaegers
 WHERE launch = (SELECT MIN(launch) FROM jaegers)
 ORDER BY launch;

\echo 'Информация тех роботов, которые уничтожили больше всех kaiju'
SELECT model_name, mark, launch, kaiju_kill
  FROM jaegers
 WHERE kaiju_kill = (SELECT MAX(kaiju_kill) FROM jaegers)
 ORDER BY model_name ASC;

\echo 'Средний вес роботов c округлением до трех знаков после запятой'
SELECT ROUND(AVG(weight), 3) AS avg_weight
  FROM jaegers;

\echo 'Увеличение количества убитых kaiju на 1 у неразрушенных роботов'
UPDATE jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status != 'Destroyed';

\echo 'Вся таблица'
SELECT *
  FROM jaegers
 ORDER BY model_name ASC;

\echo 'Удаление уничтоженных роботов'
DELETE FROM jaegers
 WHERE status = 'Destroyed';

\echo 'Оставшиеся роботы'
SELECT *
  FROM jaegers
 ORDER BY model_name ASC;
