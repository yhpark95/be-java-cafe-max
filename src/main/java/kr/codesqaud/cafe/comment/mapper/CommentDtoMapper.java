package kr.codesqaud.cafe.comment.mapper;

import kr.codesqaud.cafe.comment.domain.Comment;
import kr.codesqaud.cafe.comment.dto.RequestForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentDtoMapper {

    CommentDtoMapper INSTANCE = Mappers.getMapper(CommentDtoMapper.class);

    @Mapping(target = "userId", source = "userId")
    Comment toComment(RequestForm requestForm, String userId);

}