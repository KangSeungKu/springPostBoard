-- 해당 테이블은 테스트 계정에만 있기 때문에
-- 개발자가 실수로 운영디비 설정을 사용해도 해당 sql이 정상적으로 실행되지 않으면서
-- 이후에 등장하는 sql들은 실행되지 않는다. populator.setContinueOnError(false);
select * from not_exists_in_prd;

-- users 테이블 데이터 전체 지우기
-- delete users;		-- 복구가 가능(아카이브 로그를 남김)
truncate table postboard; 	-- 복구가 불가능(아카이브 로그를 남기지 않음)

Insert into POSTBOARD (BOARDSEQ,BOARDNM,BOARDUSAGE,USERID,BOARD_DT) values (1,'자유게시판','Y','brown',to_date('2019/08/29','YYYY/MM/DD'));
Insert into POSTBOARD (BOARDSEQ,BOARDNM,BOARDUSAGE,USERID,BOARD_DT) values (3,'공지사항','N','brown',to_date('2019/08/29','YYYY/MM/DD'));
Insert into POSTBOARD (BOARDSEQ,BOARDNM,BOARDUSAGE,USERID,BOARD_DT) values (2,'FAQ게시판','Y','brown',to_date('2019/08/29','YYYY/MM/DD'));
Insert into POSTBOARD (BOARDSEQ,BOARDNM,BOARDUSAGE,USERID,BOARD_DT) values (4,'도시락','N','brown',to_date('2019/08/29','YYYY/MM/DD'));
Insert into POSTBOARD (BOARDSEQ,BOARDNM,BOARDUSAGE,USERID,BOARD_DT) values (7,'QnA게시판','Y','brown',to_date('2019/09/03','YYYY/MM/DD'));
Insert into POSTBOARD (BOARDSEQ,BOARDNM,BOARDUSAGE,USERID,BOARD_DT) values (8,'QnA','N','brown',to_date('2019/09/03','YYYY/MM/DD'));
Insert into POSTBOARD (BOARDSEQ,BOARDNM,BOARDUSAGE,USERID,BOARD_DT) values (9,'테스트','N','brown',to_date('2019/09/03','YYYY/MM/DD'));


-- Post(게시글 테이블)

truncate table post;

Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (34,1,'안녕하세요','brown',to_date('2019/08/31','YYYY/MM/DD'),'Y',null,34);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (35,2,'Faq','brown',to_date('2019/08/31','YYYY/MM/DD'),'N',null,35);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (36,1,'안녕하세요','brown',to_date('2019/09/02','YYYY/MM/DD'),'N',null,36);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (37,1,'테스트입니다.','brown',to_date('2019/09/02','YYYY/MM/DD'),'N',null,37);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (38,1,'안녕하세요','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',null,38);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (39,1,'답글입니다.','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',null,39);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (1,1,'첫번째 글입니다','brown',to_date('2019/08/29','YYYY/MM/DD'),'Y',null,1);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (2,1,'두번째 글입니다','cony',to_date('2019/08/29','YYYY/MM/DD'),'N',null,2);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (3,1,'세번째 글은 두번째 글의 답글입니다','brown',to_date('2019/08/29','YYYY/MM/DD'),'Y',2,2);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (4,1,'네번째 글입니다','sally',to_date('2019/08/29','YYYY/MM/DD'),'Y',null,4);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (5,1,'다섯번째 글은 네번째 글의 답글입니다','cony',to_date('2019/08/29','YYYY/MM/DD'),'Y',4,4);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (6,1,'여섯번째 글은 다섯번째 글의 답글입니다','sally',to_date('2019/08/29','YYYY/MM/DD'),'Y',5,4);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (7,1,'일곱번째 글은 여섯번째 글의 답글입니다','sally',to_date('2019/08/29','YYYY/MM/DD'),'Y',6,4);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (8,1,'여덜번째 글은 다섯번째 글의 답글입니다','brown',to_date('2019/08/29','YYYY/MM/DD'),'Y',5,4);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (9,1,'아홉번째 글은 첫번째 글의 답글입니다','brown',to_date('2019/08/29','YYYY/MM/DD'),'Y',1,1);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (10,1,'열번째 글은 네번째 글의 답글입니다','cony',to_date('2019/08/29','YYYY/MM/DD'),'Y',4,4);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (11,1,'열한번째 글은 열번째 글의 답글입니다','james',to_date('2019/08/29','YYYY/MM/DD'),'Y',10,4);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (41,1,'안녕하세요','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',null,41);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (42,1,'답글1','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',null,42);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (43,1,'답글2','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',null,43);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (44,1,'답글3(수정)','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',null,44);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (46,1,'답글2-2','brown',to_date('2019/09/02','YYYY/MM/DD'),'N',43,43);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (47,1,'답글2-2-2','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',46,43);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (48,1,'새글입니다.','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',null,48);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (49,1,'새글!','brown',to_date('2019/09/02','YYYY/MM/DD'),'N',null,49);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (50,1,'첫번째','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',null,50);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (51,1,'안녕하세요','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',null,51);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (52,4,'[이벤트] 9월 혜인 도시락 이벤트!!','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',null,52);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (53,2,'[FAQ게시판]공지사항 관련사항','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',null,53);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (54,2,'후원합니다!!!','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',53,53);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (55,2,'[후원관련]게시글 삭제 바랍니다.','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',54,53);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (56,2,'테스트','brown',to_date('2019/09/03','YYYY/MM/DD'),'N',55,53);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (57,1,'테스트1','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',null,57);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (58,7,'[알림]여기는 QnA게시판 입니다.','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',null,58);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (59,7,'후원드립니다','brown',to_date('2019/09/03','YYYY/MM/DD'),'N',58,58);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (60,1,'안녕하세요(수정)','brown',to_date('2019/09/03','YYYY/MM/DD'),'N',null,60);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (61,1,'답글','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',60,60);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (62,1,'공부 열심히 하라능','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',null,62);
Insert into POST (POSTSEQ,BOARDSEQ,POSTTITLE,USERID,POST_DT,POSTDEL,PARENTSEQ,GN) values (63,1,'공부 열심히 하라능','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',null,63);


-- COMMENTS(댓글 테이블)

truncate table comments;

Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (8,'ㅎㅎ','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',49);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (6,'댓글입니다.(수정)','brown',to_date('2019/09/02','YYYY/MM/DD'),'N',1);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (9,'ㅎㅎ','brown',to_date('2019/09/02','YYYY/MM/DD'),'N',49);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (10,'안녕하세요','brown',to_date('2019/09/02','YYYY/MM/DD'),'N',49);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (11,'제발좀','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',49);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (12,'안녕하세요','brown',to_date('2019/09/02','YYYY/MM/DD'),'Y',49);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (13,'ㅎㅎ','brown',to_date('2019/09/03','YYYY/MM/DD'),'N',51);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (14,'굳굳','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',51);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (15,'다음 기회가 있긴 한건가요???','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',52);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (16,'ㅎㅇㅎㅇ','cony',to_date('2019/09/03','YYYY/MM/DD'),'Y',51);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (17,'축하드려요','cony',to_date('2019/09/03','YYYY/MM/DD'),'Y',53);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (18,'안녕하세요','brown',to_date('2019/09/03','YYYY/MM/DD'),'N',58);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (19,'네 안녕하세요','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',58);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (20,'1','brown',to_date('2019/09/03','YYYY/MM/DD'),'Y',61);
Insert into COMMENTS (COMMSEQ,COMMCONT,COMMWRITER,COMM_DT,COMMDEL,POSTSEQ) values (21,'2','brown',to_date('2019/09/03','YYYY/MM/DD'),'N',61);


--ATTAFILE (첨부파일 테이블)

truncate table ATTAFILE;

Insert into ATTAFILE (ATTASEQ,ATTAFILENAME,ATTAREALFILENAME,POSTSEQ) values (11,'cony.png','d:\upload\2019\08\32fb9d79-2460-4eb6-8cc7-0b401fc297f4.png',35);
Insert into ATTAFILE (ATTASEQ,ATTAFILENAME,ATTAREALFILENAME,POSTSEQ) values (12,'james.png','d:\upload\2019\08\b5a649c2-5125-493c-861d-771eabe73897.png',35);
Insert into ATTAFILE (ATTASEQ,ATTAFILENAME,ATTAREALFILENAME,POSTSEQ) values (13,'ryan.png','d:\upload\2019\09\e07adb59-c422-4e90-ac2d-1f3006ceffd9.png',36);
Insert into ATTAFILE (ATTASEQ,ATTAFILENAME,ATTAREALFILENAME,POSTSEQ) values (14,'sally.png','d:\upload\2019\09\8a1e776d-34db-4a9a-af70-bbddf94302ed.png',36);
Insert into ATTAFILE (ATTASEQ,ATTAFILENAME,ATTAREALFILENAME,POSTSEQ) values (15,null,'d:\upload\2019\09\30816bc4-ce2f-41ff-98bc-1a8334218ca3',37);
Insert into ATTAFILE (ATTASEQ,ATTAFILENAME,ATTAREALFILENAME,POSTSEQ) values (16,'ryan.png','d:\upload\2019\09\ee235c55-9afe-4a85-bae8-2ff45df95ab6.png',38);
Insert into ATTAFILE (ATTASEQ,ATTAFILENAME,ATTAREALFILENAME,POSTSEQ) values (8,'brown.png','d:\upload\2019\08\36c217d0-cb9c-4efb-8e26-449b3bbd3b36.png',34);
Insert into ATTAFILE (ATTASEQ,ATTAFILENAME,ATTAREALFILENAME,POSTSEQ) values (9,'cony.png','d:\upload\2019\08\ae6d9d24-423c-4659-bf84-b92a56496ce8.png',34);

commit;