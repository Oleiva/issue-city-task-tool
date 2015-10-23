package edu.com.softserveinc.bawl.dao;

import edu.com.softserveinc.bawl.models.HistoryModel;
import edu.com.softserveinc.bawl.models.IssueModel;
import edu.com.softserveinc.bawl.query.HistoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Illia on 10/5/2015.
 */
public interface HistoryDao  extends JpaRepository<HistoryModel, Integer> {

    List <HistoryModel> findByUserId (int userId);

    List <HistoryModel> findByIssueId (int issueId);

    @Query(value = HistoryQuery.uniqueLastByDateHistories, nativeQuery = true)
    List <HistoryModel> getUniqueLastByDateHistories();

    @Query(value = HistoryQuery.lastIssueByIssueID, nativeQuery = true)
    HistoryModel getLastByIssueIDHistory(@Param("issueId") int issueId);




}
