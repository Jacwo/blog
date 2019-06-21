package com.yyl.api;


import com.yyl.model.Tag;
import com.yyl.model.TagQuery;

import java.util.List;

public interface TagService {
    List<Tag> getTagList(TagQuery tagQuery);
    List<Tag> getTagByArticleID(Integer articleId);
}
