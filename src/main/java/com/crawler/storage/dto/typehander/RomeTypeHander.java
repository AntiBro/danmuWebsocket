package com.crawler.storage.dto.typehander;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.crawler.storage.dto.RomeType;


public class RomeTypeHander extends BaseTypeHandler<RomeType> {
	
	@SuppressWarnings("unused")
	private Class<RomeType> type;  
	  
    private  RomeType[] enums;  
    
    
    
    public RomeTypeHander(Class<RomeType> type){
    	if (type == null)  
    		throw new IllegalArgumentException("Type argument cannot be null");  
        this.type = type;  
        this.enums = type.getEnumConstants();  
        if (this.enums == null)  
            throw new IllegalArgumentException(type.getSimpleName()  
                    + " does not represent an enum type.");  
    	
    }

	@Override
	public RomeType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		 // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型  
        String i = rs.getString(columnName);  
        if (rs.wasNull()) {  
            return null;  
        } else {  
            // 根据数据库中的value值，定位RomeType子类  
            return RomeType.getEnum(i);  
        }  
	}

	@Override
	public RomeType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		 // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型  
        String i = rs.getString(columnIndex);  
       if (rs.wasNull()) {  
           return null;  
       } else {  
            // 根据数据库中的value值，定位RomeType子类  
           return RomeType.getEnum(i);  
       }  
	}

	@Override
	public RomeType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		   // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型  
	     String i = cs.getString(columnIndex);  
	       if (cs.wasNull()) {  
	           return null;  
	       } else {  
	         // 根据数据库中的value值，定位PersonType子类  
	           return RomeType.getEnum(i);  
	       }  
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, RomeType parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		   ps.setString(i, parameter.getTypeNumber());  
	}

}
