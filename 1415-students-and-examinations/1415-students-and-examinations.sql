# Write your MySQL query statement below
-- select s.student_id,s.student_name,S.subject_name,attended_exams=(select count(select student_id from Students cross join Subjects join Examinations on Students.student_id=Examinations.student_id)) as attended_exams from Students s Cross join Subjects S join Examination e on s.student_id=e.student_id
select s.student_id,s.student_name,su.subject_name,count(e.student_id) attended_exams
from Students s
cross join Subjects su
left join Examinations E
on s.student_id=e.student_id
and su.subject_name=e.subject_name
group by s.student_id,s.student_name,su.subject_name
order by s.student_id,s.student_name,su.subject_name