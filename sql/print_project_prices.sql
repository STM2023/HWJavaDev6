
SELECT   CONCAT('Project ', project.id)  AS name, 
(SUM( worker.salary)*  ((YEAR(project.finish_date) -YEAR(project.start_date))*12 +(MONTH( project.finish_date)-MONTH(project.start_date) ) ))  AS price
FROM worker, project_worker, project
WHERE  worker.id= project_worker.worker_id AND project_worker.project_id=project.id
GROUP BY   name  
ORDER BY  price DESC ;



