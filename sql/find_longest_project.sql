
SELECT  CONCAT( 'Project  ' , id) AS name, 
((YEAR( finish_date) -YEAR(start_date))*12 +(MONTH( finish_date)-MONTH(start_date) ) ) AS month_count
FROM  project   
WHERE    ( finish_date - start_date) =(
                  SELECT  MAX( finish_date - start_date) 
                  FROM  project
);

