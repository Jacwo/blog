package com.yyl.api;

import com.yyl.model.Tag;
import com.yyl.model.TagQuery;

import java.util.List;

public interface TagService {
    List<Tag> getTagList(TagQuery tagQuery);
    List<Tag> getTagByArticleID(Integer articleId);
    Integer selectTotal();
    void saveIP(String remoteHost, String city);

    boolean queryByIp(String remoteHost);
}
