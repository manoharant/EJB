@Entity
@NamedQuery(name=”getAllCurrencies”, query=”Select c from Currency c”)
public class Currency implements Serializable {
	@Id private int id;
 
	@Column(length=3,nullable=false) private String symbol;
	@Column(nullable=false) private String name;
	private Double rate;	
	private Date rateDate;
 
	@ManyToOne
	private Currency baseCurrency;
 
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
 
	public String getSymbol() { return symbol; }
	public void setSymbol(String symbol) { this.symbol = symbol; }
 
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
 
	public Double getRate() { return rate; }
	public void setRate(Double rate) { this.rate = rate; }
 
	public Date getRateDate() { return rateDate; }
	public void setRateDate(Date rateDate) { 
	this.rateDate = rateDate; 
	}
}