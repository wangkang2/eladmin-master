
package com.wk.modules.mnt.repository;

import com.wk.modules.mnt.domain.ServerDeploy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author zhanghouying
* @date 2019-08-24
*/
public interface ServerDeployRepository extends JpaRepository<ServerDeploy, Long>, JpaSpecificationExecutor<ServerDeploy> {

    /**
     * 根据IP查询
     * @param ip /
     * @return /
     */
    ServerDeploy findByIp(String ip);
}
