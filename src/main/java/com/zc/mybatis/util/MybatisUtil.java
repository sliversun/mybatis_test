package com.zc.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.io.Reader;

public final class MybatisUtil {
    private static Logger log = Logger.getLogger(MybatisUtil.class);
    //使用内部enum实现单例并封装细节
    private enum MyFactorySingleton {
        factory;
        private SqlSessionFactory sessionFactory = null;
        private String XML;

        private MyFactorySingleton() {
            Reader is = null;
            try {
                XML = "conf.xml";
                is = Resources.getResourceAsReader(XML);
                sessionFactory = new SqlSessionFactoryBuilder().build(is);
            } catch (IOException e) {
                log.error("XML路径加载失败！");
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        log.error("Reader  close fairue!");
                    }
                }
            }
        }

        public SqlSessionFactory getFactory() {
            return sessionFactory;
        }
    }

    //sqlSession 获取公开接口
    public static SqlSession getSession() {
        return MyFactorySingleton.factory.sessionFactory.openSession(true);
    }
}
