package org.example.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatisplus.entity.FilAwbInfo;

@Mapper
public interface FilAwbInfoDao {
    FilAwbInfo queryAwb(FilAwbInfo awbInfo);
}
