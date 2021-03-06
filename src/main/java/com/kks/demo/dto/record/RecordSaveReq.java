package com.kks.demo.dto.record;

import com.kks.demo.domain.record.Records;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecordSaveReq {

    private String userId;
    private String title;

    private int categoryId;
    private float rate;
    private String content;
    private int postPublic;

  //  private String imgUrl;
    private String postDate;

    private int commentCount;

    @Builder
    public RecordSaveReq(String userId, String title, int categoryId, float rate, String content, String postDate, int postPublic,
                         String imgUrl, int commentCount){
        this.userId = userId;
        this.title = title;
        this.categoryId = categoryId;
        this.rate = rate;
        this.content = content;
        this.postPublic = postPublic;
    //    this.imgUrl = imgUrl;
      this.postDate = postDate;
        this.commentCount = commentCount;
    }

    public Records toEntity() {
        return Records.builder()
                .userId(userId)
                .title(title)
                .categoryId(categoryId)
                .rate(rate)
                .content(content)
                .postPublic(postPublic)
     //           .imgUrl(imgUrl)
               .postDate(postDate)
                .commentCount(commentCount)
                .build();
    }
}
