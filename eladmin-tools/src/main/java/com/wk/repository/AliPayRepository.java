
package com.wk.repository;

import com.wk.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wang kang
 * @date 2018-12-31
 */
public interface AliPayRepository extends JpaRepository<AlipayConfig,Long> {
}
