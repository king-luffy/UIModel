package service.mapper;

import service.po.DBTableFieldPo;
import service.po.DBTablePo;

import java.util.List;

/**
 * Created by king_luffy on 2017/9/7.
 */
public interface DBInfoFetchMapper {

    /**
     * 获取数据库所有表名
     * @return
     */
    List<DBTablePo> getDBTableInfo();


    /**
     * 获取数据库表的所有字段信息
     * @return
     */
    List<DBTableFieldPo> getDBTableFieldsInfo(String tableName);
}
