package com.kks.demo.service;

import com.kks.demo.config.BaseException;
import com.kks.demo.config.BaseResponseStatus;
import com.kks.demo.dao.record.RecordDao;
import com.kks.demo.domain.recordlike.RecordLikeRespository;
import com.kks.demo.domain.recordlike.RecordLikes;
import com.kks.demo.dto.Like;
import com.kks.demo.dto.like.PostLikeReq;
import com.kks.demo.dto.recordlike.LikeResponseDto;
import com.kks.demo.provider.RecordLikeProvider;
import com.kks.demo.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RecordLikeService {


    private final RecordDao recordDao;
    private final RecordLikeProvider recordLikeProvider;
    private final RecordLikeRespository recordLikeRespository;

    private final LikeRepository likeRepository;

    /**
     * 레코드(글)에 좋아요 하기
     */
    public String createRecordLike(PostLikeReq postLikeReq) throws BaseException{
        try{
            String result = null;
            if(recordLikeProvider.likeRecordIdxExist(postLikeReq.getRecordIdx()) == 0)
                throw new BaseException(BaseResponseStatus.GET_QUESTIONS_EMPTY_DATA);
            switch (recordLikeProvider.getLikeStatus(postLikeReq)){
                case 1:     //생성된 게 없을 때
                    result = recordDao.createRecordLike(postLikeReq, 1);
                    break;
                case 2: // 생성됐으나 inactive상태
                    result = recordDao.createRecordLike(postLikeReq, 2);
                    break;
                case 3: //생성됐으나 active상태
                    result = recordDao.createRecordLike(postLikeReq, 3);

            }
            return result;

        }catch (BaseException baseException){
            baseException.printStackTrace();
            throw new BaseException(baseException.getStatus());
        }catch (Exception exception){
            exception.printStackTrace();
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }

    //게시글 좋아요 개수
    @Transactional
    public String CountLike(int recordIdx){
        long num = recordLikeRespository.countByRecordIdxAndStatus(recordIdx,"ACTIVE");
        String result = Long.toString(num);
        return result;
    }

    //status 반환
    @Transactional
    public String LikeStatus(int recordIdx, String userId){
        RecordLikes like = recordLikeRespository.findByRecordIdxAndUserId(recordIdx, userId);

        if (like != null){
            LikeResponseDto likedto = new LikeResponseDto(like);
            if (likedto.getStatus().equals("ACTIVE"))    return "1";
            else return "0";
        }

        return "0";
    }


    public int getRecordLikedCnt(int recordIdx){
        return likeRepository.getRecordLikedCnt(recordIdx);
    }

    public String getRecordLikeActive(int recordIdx, String userId){
        return likeRepository.getRecordLikeActive(recordIdx, userId);
    }
}
