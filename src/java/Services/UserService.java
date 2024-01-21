package Services;

import java.sql.ResultSet;
import java.sql.SQLException;

import Repositories.Common.RepositoryBase;
import Repositories.Entities.UserEntity;

public class UserService extends RepositoryBase<UserEntity> {

    @Override
    protected UserEntity createEntityFromResultSet(ResultSet rs) throws SQLException {
        return new UserEntity(rs);
    }

    @Override
    protected String getTableName() {
        return "Users";
    }

}
