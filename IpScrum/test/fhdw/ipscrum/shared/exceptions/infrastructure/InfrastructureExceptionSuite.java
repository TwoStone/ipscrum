/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({
		BuildModelExceptionTest.class,
		CommitExceptionTest.class,
		ConflictExceptionTest.class,
		LoginExceptionTest.class,
		ModelLockedExceptionTest.class,
		NoObjectFindExceptionTest.class,
		NoOpenTransactionExceptionTest.class,
		NotAuthorizedExceptionTest.class,
		PendingCommitExceptionTest.class,
		PersistenceExceptionTest.class,
		PersistenceFileNotFoundExceptionTest.class })
public class InfrastructureExceptionSuite {

}
