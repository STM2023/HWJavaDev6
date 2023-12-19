
SELECT  client.name, count(project.client_id) AS project_count  
FROM  project , client
WHERE project.client_id=client.id
GROUP BY  client.name
HAVING count(project.client_id)  IN (
       SELECT  count(client_id)
       FROM project  
       GROUP BY client_id 
       ORDER BY  count(client_id) DESC LIMIT 1
 );




