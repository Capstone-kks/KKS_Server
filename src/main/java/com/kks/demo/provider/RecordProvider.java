package com.kks.demo.provider;


import com.kks.demo.dto.record.RecordDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;



//Provider : Read의 비즈니스 로직 처리
@Service    // [Business Layer에서 Service를 명시하기 위해서 사용] 비즈니스 로직이나 respository layer 호출하는 함수에 사용된다.
            // [Business Layer]는 컨트롤러와 데이터 베이스를 연결
/**
 * Provider란?
 * Controller에 의해 호출되어 실제 비즈니스 로직과 트랜잭션을 처리: Read의 비즈니스 로직 처리
 * 요청한 작업을 처리하는 관정을 하나의 작업으로 묶음
 * dao를 호출하여 DB CRUD를 처리 후 Controller로 반환
 */
@ComponentScan(basePackages={"package com.kks.demo.dto.record"})
public class RecordProvider {


    // *********************** 동작에 있어 필요한 요소들을 불러옵니다. *************************
    private final RecordDao recordDao;



    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RecordProvider(RecordDao recordDao) {
        this.recordDao = recordDao;
    }


    // ******************************************************************************

//    public void sample(RecordSaveDto requestDto){
//        String result =recordDao.postRecord(requestDto);
//    }



}
