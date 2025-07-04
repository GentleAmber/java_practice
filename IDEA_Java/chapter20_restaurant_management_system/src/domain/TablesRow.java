package domain;

public class TablesRow {
    private int table_no;
    private String status;
    private short max_num_of_ppl;

    public TablesRow() {
    }

    public int getTable_no() {
        return table_no;
    }

    public void setTable_no(int table_no) {
        this.table_no = table_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public short getMax_num_of_ppl() {
        return max_num_of_ppl;
    }

    public void setMax_num_of_ppl(short max_num_of_ppl) {
        this.max_num_of_ppl = max_num_of_ppl;
    }

    public TablesRow(int table_no, String status, short max_num_of_ppl) {
        this.table_no = table_no;
        this.status = status;
        this.max_num_of_ppl = max_num_of_ppl;
    }

    @Override
    public String toString() {
        return table_no + "\t\t\t\t" + status + "\t\t\t" + max_num_of_ppl;
    }
}
