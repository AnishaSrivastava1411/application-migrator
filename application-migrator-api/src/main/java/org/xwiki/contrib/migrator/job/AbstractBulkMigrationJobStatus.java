/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.migrator.job;

import java.util.Map;

import org.xwiki.contrib.migrator.MigrationStatus;
import org.xwiki.job.DefaultJobStatus;
import org.xwiki.job.event.status.JobStatus;
import org.xwiki.logging.LoggerManager;
import org.xwiki.observation.ObservationManager;

/**
 * Define the job status used for {@link AbstractBulkMigrationJob}.
 *
 * @version $Id$
 * @since 1.0
 */
public abstract class AbstractBulkMigrationJobStatus extends DefaultJobStatus<AbstractBulkMigrationJobRequest>
{
    /**
     * Builds a new {@link AbstractBulkMigrationJobStatus}.
     *
     * @param jobType the type of the job
     * @param request the job request
     * @param parentJobStatus the parent job status
     * @param observationManager the observation manager
     * @param loggerManager the logger manager
     */
    public AbstractBulkMigrationJobStatus(
            String jobType,
            AbstractBulkMigrationJobRequest request,
            JobStatus parentJobStatus,
            ObservationManager observationManager,
            LoggerManager loggerManager)
    {
        super(jobType, request, parentJobStatus, observationManager, loggerManager);
    }

    /**
     * Define the migration statuses that are returned by the migration executors.
     *
     * @param migrationStatuses the migration statuses
     */
    public abstract void setMigrationStatuses(Map<String, MigrationStatus> migrationStatuses);

    /**
     * @return a map containing, for each migration performed (identified by its UUID), the status returned by
     * the migration executor.
     */
    public abstract Map<String, MigrationStatus> getMigrationStatuses();
}
