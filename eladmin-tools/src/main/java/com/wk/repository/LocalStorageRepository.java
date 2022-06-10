
package com.wk.repository;

import com.wk.domain.LocalStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author wang kang
* @date 2019-09-05
*/
public interface LocalStorageRepository extends JpaRepository<LocalStorage, Long>, JpaSpecificationExecutor<LocalStorage> {
}