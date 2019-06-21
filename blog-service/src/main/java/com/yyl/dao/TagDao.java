package com.yyl.dao;

import com.yyl.model.Tag;
import com.yyl.model.TagQuery;

import java.util.List;

public interface TagDao {
    List<Tag> getTagList(TagQuery tagQuery);

    List<Tag> getTagByArticleID(Integer articleId);
}
