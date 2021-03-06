package com.example.mvvmreactive.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jakewharton.rxbinding2.support.v7.widget.RecyclerViewScrollEvent;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

public class ScrollEventCalculatorTest {

    @Test
    public void isAtScrollEnd() throws Exception {
        //
        //Arrange
        //
        LinearLayoutManager mockLinearLayoutManager = Mockito.mock(LinearLayoutManager.class);
        RecyclerView mockRecyclerView = Mockito.mock(RecyclerView.class);
        RecyclerViewScrollEvent mockRecyclerViewScrollEvent = Mockito.mock(RecyclerViewScrollEvent.class);

        when(mockLinearLayoutManager.getItemCount()).thenReturn(50);
        when(mockLinearLayoutManager.findLastVisibleItemPosition()).thenReturn(50);

        when(mockRecyclerView.getLayoutManager()).thenReturn(mockLinearLayoutManager);

        when(mockRecyclerViewScrollEvent.dx()).thenReturn(0);
        when(mockRecyclerViewScrollEvent.dy()).thenReturn(100);
        when(mockRecyclerViewScrollEvent.view()).thenReturn(mockRecyclerView);

        //
        //Act
        //
        ScrollEventCalculator scrollEventCalculator = new ScrollEventCalculator(mockRecyclerViewScrollEvent);
        boolean value = scrollEventCalculator.isAtScrollEnd();

        //
        //Assert
        //
        assertThat(value).isTrue();
    }

    @Test
    public void isAtScrollEnd_false() throws Exception {
        //
        //Arrange
        //
        LinearLayoutManager mockLinearLayoutManager = Mockito.mock(LinearLayoutManager.class);
        RecyclerView mockRecyclerView = Mockito.mock(RecyclerView.class);
        RecyclerViewScrollEvent mockRecyclerViewScrollEvent = Mockito.mock(RecyclerViewScrollEvent.class);

        when(mockLinearLayoutManager.getItemCount()).thenReturn(50);
        when(mockLinearLayoutManager.findLastVisibleItemPosition()).thenReturn(5);

        when(mockRecyclerView.getLayoutManager()).thenReturn(mockLinearLayoutManager);

        when(mockRecyclerViewScrollEvent.dx()).thenReturn(0);
        when(mockRecyclerViewScrollEvent.dy()).thenReturn(100);
        when(mockRecyclerViewScrollEvent.view()).thenReturn(mockRecyclerView);

        //
        //Act
        //
        ScrollEventCalculator scrollEventCalculator = new ScrollEventCalculator(mockRecyclerViewScrollEvent);
        boolean value = scrollEventCalculator.isAtScrollEnd();

        //
        //Assert
        //
        assertThat(value).isFalse();
    }

}