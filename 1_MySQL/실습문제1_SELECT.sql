-- sakila, 정렬은 결과 화면대로

-- 1. actor 테이블에서 first_name이 A로 시작하는 배우들만 조회 
SELECT actor_id, first_name, last_name, last_update
FROM actor
WHERE first_name LIKE 'A%';

-- 풀이
SELECT *
FROM actor
WHERE first_name LIKE 'A%';

-- 2. film_list 테이블에서 category가 Sci-Fi 또는 Family면서
-- rating이 PG면서 영화 제목(title)에 GO가 포함되는 영화 제목 조회
SELECT title
FROM film_list
WHERE category IN ('Sci-Fi', 'Family')
	AND rating = 'PG'
    AND title LIKE '%GO%';

-- 풀이
SELECT title
FROM film_list
-- WHERE (category = 'Sci-Fi' OR category = 'Family')
WHERE category IN ('Sci-Fi', 'Family')
	AND rating = 'PG'
    AND title LIKE '%GO%';

-- 3. film_list 테이블에서 fid가 7 이하면서 4, 6은 아닌 fid, title 조회
SELECT fid, title
FROM film_list
WHERE fid <= 7 AND fid NOT IN (4, 6);

-- 풀이
SELECT fid, title
FROM film_list
WHERE fid <= 7
-- AND (fid != 4 AND fid != 6);
   AND fid NOT IN (4, 6);

-- 4. film_list 테이블에서 가격(price)은 2 이상 4 이하이면서 category가 Documentary거나 Animation이고 
-- 배우들(actors) 중 BOB가 포함되어 있는 영화 제목(title)만 조회
SELECT title
FROM film_list
WHERE price BETWEEN 2 AND 4
	AND category IN ('Documentary', 'Animation')
    AND actors LIKE '%BOB%';

-- 풀이
SELECT title
FROM film_list
-- WHERE price >= 2 AND price <= 4
WHERE price BETWEEN 2 AND 4
	AND category IN ('Documentary', 'Animation')
    AND actors LIKE '%BOB%';

-- 5. address 테이블에서 district가 비어있지 않고 앞에 숫자 제외 주소만 10개 조회
-- 정규표현식 못 쓰나 /^[0-9]$/
SELECT address, substr(address, 1, 4), trim(district)
FROM address
ORDER BY district, address DESC
LIMIT 0, 10;

/* 좋은 시도였다..
SELECT address, lpad(address, 20, '*')
from address;

select char_length(address)
FROM address;

SELECT address, substr(address, 1, 4), trim(district)
FROM address;
-- SELECT address, substr(address, 4, instr(address, '0123456789')), trim(district)
-- substr(address, 1, instr(address, '0123456789') + 1)
-- replace(address, 0123456789, '')
*/

-- 풀이
SELECT * FROM address WHERE district = '' AND district IS NOT NULL;
-- 첫번째 공백 위치 확인 instr(address, ' ')
-- substr(address, instr(address, ' ') + 1, 추출할 문자 개수)
-- substr 특징 : 추출할 문자 개수 생략할 시 끝까지 다 추출함
SELECT substr(address, instr(address, ' ') + 1) address, district ''
FROM address
WHERE district != ''
ORDER BY 2, 1 DESC
LIMIT 0, 10;

-- 질문. 문자열에서 정규표현식 사용하여 해당하는 값만 못 뽑아오나요
-- SELECT regexp_replace(컬럼, 정규표현식, 대체되는글자)
SELECT
	address,
    trim(regexp_replace(address, '[0-9]+', ''))
FROM address;

-- 6. customer_list 테이블에서 id가 6인 사람부터 10명 조회
SELECT id, name
FROM customer_list
WHERE id >= '6'
ORDER BY id
LIMIT 10;

-- 풀이
SELECT id, name
FROM customer_list
ORDER BY id
LIMIT 5, 10;

-- 7. actor 테이블에서 J로 시작하는 이름과 글자수 조회 (공백 X, 정렬은 글자수가 많은 사람 순으로)
SELECT concat(first_name, " ", last_name) 이름, char_length(first_name) + char_length(last_name) 글자수
FROM actor
WHERE concat(first_name, last_name) LIKE 'J%'
ORDER BY 2 DESC, last_name desc;

-- 풀이
SELECT
	concat(first_name, ' ', last_name) 이름,
	char_length(concat(first_name, last_name)) 글자수
FROM actor
WHERE first_name LIKE 'J%'
ORDER BY 글자수 DESC;

-- 8. film 테이블에서 description에서 of 이전 문장만 중복 없이 10개만 추출해서 조회
SELECT DISTINCT substr(description, 1, instr(description, 'of') - 1) "of 이전 문장"
FROM film
ORDER BY 1 DESC
LIMIT 10;

-- 풀이
-- instr(description, 'of') >> of의 위치
-- SELECT description, substr(description, 시작위치, 몇개까지자를거냐)
SELECT distinct substr(description, 1, instr(description, 'of') -2) "of 이전 문장"
FROM film
ORDER BY 1 DESC
LIMIT 10;

-- 9. film 테이블에서 replacement_cost 최소 비용과 최대 비용 조회
SELECT MIN(replacement_cost) "최소 비용", MAX(replacement_cost) "최대 비용"
FROM film;

-- 풀이
SELECT min(replacement_cost) "최소 비용", max(replacement_cost) "최대 비용"
FROM film;