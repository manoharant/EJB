@Singleton
@LocalBean
@Startup
public class CurrencyCacheBean implements CurrencyCache {
	@PersistenceContext
	private EntityManager em;
 
	private ConcurrentMap<String,Currency> cache;
 
	private void loadCurrencies() {
		Query query = em.getNamedQuery(“getAllCurrencies”,Currency.class);
		List currencies = query.getResultList();
		for(Currency c : currencies) {
			currencies.put(c.getSymbol(),c);
		}
	}
 
	@Lock(READ)
	public Currency getCurrency(String symbol) {
		return currencies.get(symbol);
	}
 
	@PostConstruct
	public void init() {
		cache = new ConcurrentHashMap<String,Currency>();
		loadCurrencies();
	}
 
	@Schedule(minute=”15”, hour=”7”, dayOfWeek=”*”)
	public void reload() {
		cache.clear();
		loadCurrencies();
	}
}