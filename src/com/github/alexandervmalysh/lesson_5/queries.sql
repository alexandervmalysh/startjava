-- Вывод всех роботов в алфавитном порядке по полю model_name
SELECT *
  FROM jaegers
 ORDER BY model_name ASC;

-- Вывод всех роботов по полю model_name, которые не уничтожены
SELECT *
FROM jaegers
WHERE status = 'Active'
ORDER BY model_name ASC;

-- Вывод всех роботов в алфавитном порядке по полю model_name серии Mark-1 и Mark-4
SELECT *
FROM jaegers
WHERE mark IN ('1', '4')
ORDER BY model_name ASC;

-- Вывод всех роботов, кроме серии Mark-1 и Mark-4 по убыванию поля mark
SELECT *
FROM jaegers
WHERE mark NOT IN ('1', '4')
ORDER BY mark DESC;

-- Вывод самых старых роботов в алфавитном порядке
SELECT *
  FROM jaegers
 WHERE launch = (SELECT MIN(launch) FROM jaegers)
 ORDER BY launch;

-- Вывод роботов в алфавитном порядке по полю model_name, которые уничтожили больше всех kaiju
SELECT model_name, mark, launch, kaiju_kill
  FROM jaegers
 WHERE kaiju_kill = (SELECT MAX(kaiju_kill) FROM jaegers)
 ORDER BY model_name ASC;

-- Вывод среднего веса роботов с округлением до трех знаков после запятой
SELECT ROUND(AVG(weight), 3) AS avg_weight
  FROM jaegers;

-- Увеличение количества убитых kaiju на 1 для всех неразрушенных роботов
UPDATE jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status != 'Destroyed';

-- Вывод всех роботов в алфавитном порядке по полю model_name
SELECT *
  FROM jaegers
 ORDER BY model_name ASC;

-- Удаление уничтоженных роботов
DELETE FROM jaegers
 WHERE status = 'Destroyed';

-- Вывод всех роботов после удаления в алфавитном порядке по полю model_name
SELECT *
  FROM jaegers
 ORDER BY model_name ASC;
