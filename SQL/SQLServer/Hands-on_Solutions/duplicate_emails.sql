SELECT email
FROM (
  VALUES --
    ('foo@example.com'),
    ('bar@example.com'),
    ('foo@example.com')
) AS persons(email)
GROUP BY email
HAVING count(email) > 1;