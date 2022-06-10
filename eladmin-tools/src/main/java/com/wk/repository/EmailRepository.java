
package com.wk.repository;

import com.wk.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wang kang
 * @date 2018-12-26
 */
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
