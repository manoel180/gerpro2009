package br.com.gerpro.finder;


import org.springframework.aop.support.DefaultIntroductionAdvisor;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M2R
 */
public class FinderIntroductionAdvisor extends DefaultIntroductionAdvisor {
    public FinderIntroductionAdvisor() {
        super(new FinderIntroductionInterceptor());
    }
}

