package client_lib;

public class Credit extends BankService {
	private static double maxCreditAmout = 200000;
	
    private double contrib;

    public Credit() {
        super();
    }

    public Credit(int Years) {
        super(Years);
    }

    public Credit(double Body) {
        super(Body);
    }
    
    public void setNewData(int years, double percent, double body, double contrib) {
		BankService:setNewData(years, percent, body);
		this.setContrib(contrib);
	}

    public double getInterestAmount() {
		double interestAmount = this.getFinalContributionsPayments() - this.getBody();
		return interestAmount;
	}
    
    public Credit(int Years, double Percent, double Body, double contrib) {
        super(Years, Percent, Body);
        this.contrib = contrib;
    }
    
    public void setMaxCreditAmout(double newCreditAmout){
    	this.maxCreditAmout = newCreditAmout;
    }
    
    public double getMaxCreditAmout(){
    	return this.maxCreditAmout;
    }
    
    public static double getRegularContribution(int years, double body, double percent) {

		double clean_percent = percent - 1.0;

		double contrib = body * (clean_percent + (clean_percent / (Math.pow(clean_percent + 1.0, (double) years) - 1)));
		//contrib += 0.01;
		return contrib;
	}
    
 // статический метод проверки кредита через Credit
 	public static boolean isVerifyCredit(Credit credit) {
 		if (!(credit.getYears() > 0 && credit.getBody() > credit.getContrib() && credit.getPercent() > 1)) return false;
 		if (credit.getBody() * (credit.getPercent() - 1) > credit.getContrib()) return false;
 		if (credit.getBody() > maxCreditAmout) return false;

 		int TrueYears = 0;
 		double body = credit.getBody();
 		for (TrueYears = 0; body > 0; TrueYears++) {
 			body = body * credit.getPercent();
 			body -= credit.getContrib();
 		}
 		if (TrueYears != credit.getYears()) return false;

 		return true;
 	}  

 	// статический метод проверки кредита через параметры
 	public static boolean isVerifyCredit(int years, double body, double percent, double contribution) {
 		if (!(years > 0 && body > contribution && percent > 1)) return false;
 		if (body * (percent - 1.0) > contribution) return false;
 		if (body > maxCreditAmout) return false;

 		int TrueYears = 0;
 		double body_credit = body;
 		for (TrueYears = 0; body_credit > 0; TrueYears++) {
 			body_credit = body_credit * percent;
 			body_credit -= contribution;
 		}
 		if (TrueYears != years) return false;
 		
 		return true;
 	}

    public void setContrib(double newContrib) {
        contrib = newContrib;
    }

    public double getContrib() {
        return this.contrib;
    }

    public double getFinalContributionsPayments() {
        double FinalContributionsPayments = 0;
        int years = getYears();
        double body = getBody();
        double percent = getPercent();
        double contribution = getContrib();
        for (int i = 0; i < years; i++) {
            if (body < contribution) {
                FinalContributionsPayments += body;
                body = 0;
            } else {
                FinalContributionsPayments += contribution;
                body -= contribution;
                body *= percent;
            }
        }
        return FinalContributionsPayments;
    }

    public void showInConsole() {
        String Info = "Credit year: " + Integer.toString(this.getYears()) + " body: " + Double.toString(this.getBody())
                + " percent: " + Double.toString(this.getPercent()) + " contribution: "
                + Double.toString(this.getContrib());
        System.out.println(Info);
    }
}