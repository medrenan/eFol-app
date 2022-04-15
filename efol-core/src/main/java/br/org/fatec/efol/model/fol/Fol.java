package br.org.fatec.efol.model.fol;

import br.org.fatec.efol.model.equipment.Equipment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "EFOL_FOL")
public class Fol implements Serializable {

    private Long id;
    private Equipment equipment;
    private String title;
    private String applicability;
    private String issueDescription;
    private FolCategory category;
    private StatusFol status;
    private Date issueDate;
    private Integer revisionNumber;
    private Date revisionDate;
    private String remarks;
    private Set<Keyword> keywords;

    @ManyToOne
    @JoinColumn(name = "EQUIPMENT_ID")
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Column(name = "TITLE", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "APPLICABILITY")
    public String getApplicability() {
        return applicability;
    }

    public void setApplicability(String applicability) {
        this.applicability = applicability;
    }

    @Column(name = "ISSUE_DESCRIPTION", nullable = false)
    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    public FolCategory getCategory() {
        return category;
    }

    public void setCategory(FolCategory category) {
        this.category = category;
    }

    @Column(name = "STATUS", nullable = false)
    public StatusFol getStatus() {
        return status;
    }

    public void setStatus(StatusFol status) {
        this.status = status;
    }

    @Column(name = "ISSUE_DATE", nullable = false)
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Column(name = "REVISION_NUMBER")
    public Integer getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(Integer revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    @Column(name = "REVISION_DATE")
    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    @Column(name = "REMARKS")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @ManyToMany
    @JoinTable(name = "EFOL_FOL_KEYWORD", joinColumns = {
            @JoinColumn(name = "FOL_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "KEYWORD_ID", referencedColumnName = "ID")})
    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywordList) {
        this.keywords = keywordList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
